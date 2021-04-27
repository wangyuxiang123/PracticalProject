import requests
import time
import pymysql
from selenium.webdriver import Edge
from selenium.webdriver.common.keys import Keys
import json

url = 'http://search.jd.com/search.php?keyword=%E8%AE%A1%E7%AE%97%E6%9C%BA%E4%B9%A6'

db = pymysql.connect(host='115.159.41.241',
                     user='user211814405',
                     password='211814405',
                     port=3306,
                     db='db211814405')
cursor = db.cursor()

sql = 'CREATE TABLE IF NOT EXISTS books(' \
      'ID int(20) NOT NULL, ' \
      '书名 VARCHAR(255), ' \
      '价格 VARCHAR(255) ,' \
      '出版社 VARCHAR(255),' \
      'PRIMARY KEY(ID))'
cursor.execute(sql)

web = Edge(executable_path="M.exe")
html = web.get(url)
time.sleep(1)
web.find_element_by_xpath('//*[@id="J_filter"]/div[1]/div[1]/a[2]').click()  # 点击销量排序
# web.find_elements_by_class_name('fs-tit').click
time.sleep(1)

# for i in range(1000,20000,1000):
#     js = "var q=document.documentElement.scrollTop={}".format(i)
#     web.execute_script(js)
#     time.sleep(1)
#
# web.execute_script("document.documentElement.scrollTop=0")

goods = web.find_elements_by_class_name('gl-warp > li')

j = 1
for i in goods:
    results = {}
    results['ID'] = j
    results['书名'] = i.find_element_by_xpath('.//div[@class="p-name"]//em').text
    time.sleep(1)
    results['价格'] = i.find_element_by_xpath('.//div[@class="p-price"]//i').text + "￥"
    time.sleep(1)
    results['出版社'] = i.find_element_by_xpath('.//div[@class="p-shopnum"]//a').text

    table = 'books'
    keys = ', '.join(results.keys())
    values = ', '.join(['%s'] * len(results))
    sql = 'INSERT INTO {table}({keys}) VALUES ({values}) ON DUPLICATE KEY UPDATE'.format(table=table, keys=keys,
                                                                                         values=values)
    update = ','.join([" {key} = %s".format(key=key) for key in results])  # 不去重复
    sql += update
    cursor.execute(sql, tuple(results.values()) * 2)
    db.commit()
    print("插入第{}行数据成功！".format(j))
    if j == 20:
        break
    else:
        j += 1
print("done")
db.close()
