# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class DoubanMovieItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass

class DoubanMovieItem(scrapy.Item):
    # define the fields for the item in this project
    # good_No = scrapy.Field()
    name2 = scrapy.Field()
    # good_price1 = scrapy.Field()
    # good_price2 = scrapy.Field()
    score = scrapy.Field()
    url = scrapy.Field()

#    score_num = scrapy.Field()
