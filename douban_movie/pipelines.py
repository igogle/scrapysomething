# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html
import codecs
import json

class DoubanMoviePipeline(object):
    def __init__(self):
        self.file = codecs.open('result.json','wb',encoding='utf-8')

    def process_item(self, item, spider):
        line = json.dumps(dict(item),ensure_ascii=False)+'\n'
        self.file.write(line)
        return item
    def spider_closed(self, spider):
        self.file.close()