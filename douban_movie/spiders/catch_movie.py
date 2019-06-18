# -*- coding: utf-8 -*-
import scrapy

import json

# from selenium import webdriver
# from selenium.webdriver.chrome.options import Options
from douban_movie.items import DoubanMovieItem

class CatchMovieSpider(scrapy.Spider):
    name = 'catch_movie'
    allowed_domains = ['amazon.com']
    start_urls = ['https://www.amazon.com']
    #start_urls = ['https://www.amazon.com/ref=nav_logo']
    #start_urls = ['https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=0']

    def parse(self, response):
        #print(response.body.decode())
        item=DoubanMovieItem()
        #movie_list=json.loads(response.body.decode())
        # chrome_options = Options()
        # chrome_options.add_argument('--headless')
        # chrome_options.add_argument('--disable-gpu')
        #chrome_options.add_argument('--no-sandbox')
        #chrome_driver=r'C:\Users\igogle\Desktop\douban2\douban_movie\chromedriver.exe'
        #browser=webdriver.Chrome(executable_path=chrome_driver)
        #browser.get('https://www.amazon.com/ref=nav_logo')
        #browser.implicitly_wait(5)
        
        print('s')
        print('s')
        #movies=browser.find_element_by_xpath('//*[@id="desktop-4"]')
        #test=movies[0].get_attribute("li")
        movies= response.xpath('//*[@id="desktop-4"]//li/@data-sgproduct')
        print('s')
        print('s')
        print(movies)
        print(str(len(movies)))
        print('s')
        print('s')
        #print(response.xpath('//*[@id="content"]/div/div[1]/div/div[4]/div/a[1]/p/text()'))
         for movie in movies:
             print('s')
             print(movie.xpath('//p/text()').extract()[0])
            #names=movie.xpath('.//p/text()').extract()[0]
            #item['name']=names
            #item['score']=movie['score']
            #item['url']=movie['url']
            #yield item