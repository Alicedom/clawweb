package claw.web.api.controller;

import claw.web.data.fulldata.Article;
import claw.web.api.service.Entry;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data/")
public class CategoryController {

    private final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    Entry entry;

    @RequestMapping(value = "connect", method = RequestMethod.GET, params = {"url", "userAgent", "cookies", "timeout", "method"})
    public ResponseEntity connect(@RequestParam String url, @RequestParam String userAgent, @RequestParam HashMap cookies,@RequestParam int timeout, String method){
        Document document = entry.connect(url,userAgent,cookies,timeout,method);

        return new ResponseEntity<>(document.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "connect", method = RequestMethod.GET, params = {"url", "timeout"})
    public ResponseEntity connect(@RequestParam String url, @RequestParam int timeout){

        return this.connect(url, null, null, timeout, null);
    }

    @RequestMapping(value = "connect", method = RequestMethod.GET, params = {"url"})
    public ResponseEntity connect(@RequestParam String url){

        return this.connect(url, null, null, 0, null);
    }

    @RequestMapping(value = "entry", method = RequestMethod.GET, params = {"cssSelector","include","exclude"})
    public ResponseEntity getEntry(@RequestParam String cssSelector, @RequestParam String include, @RequestParam String exclude){
        List<String> entryList = entry.getEntry(cssSelector, include, exclude);

        logger.info("list size: "+ entryList.size());
        return new ResponseEntity<>(entryList, HttpStatus.OK);
    }

    @RequestMapping(value = "entry", method = RequestMethod.GET, params = {"cssSelector"})
    public ResponseEntity getEntry(@RequestParam String cssSelector){
        return this.getEntry(cssSelector,"","");
    }

    @RequestMapping(value = "short", method = RequestMethod.GET, params = {"cssSelector","cssSmaller", "include", "exclude"})
    public ResponseEntity getShortData(@RequestParam String cssSelector, @RequestParam String cssSmaller, @RequestParam String include, @RequestParam String exclude){
        List<Article> listShort = entry.getShortData(cssSelector,cssSmaller,include,exclude);
        logger.info("article size: "+listShort.size());
        return new ResponseEntity(listShort,HttpStatus.OK);
    }

    @RequestMapping(value = "short", method = RequestMethod.GET, params = {"cssSelector","cssSmaller"})
    public ResponseEntity getShortData(@RequestParam String cssSelector, @RequestParam String cssSmaller){
        return this.getShortData(cssSelector, cssSmaller,"","");

    }

    @RequestMapping(value = "short", method = RequestMethod.GET, params = {"cssSelector"})
    public ResponseEntity getShortData(@RequestParam String cssSelector){
        return this.getShortData(cssSelector, null,"","");

    }

    @RequestMapping(value = "body", method = RequestMethod.GET, params = {"cssSelectorContent","cssRemoveContent","cssQueryText","include","exclude","preURL","replace"})
    public ResponseEntity setBody(@RequestParam List<String> cssSelectorContent, @RequestParam String cssRemoveContent, @RequestParam Map cssQueryText, @RequestParam String include, @RequestParam String exclude, @RequestParam String preURL,@RequestParam String replace){
        List<Article> list = entry.setBody(cssSelectorContent,cssRemoveContent,cssQueryText,include,exclude, preURL, replace);
        return new ResponseEntity(list, HttpStatus.OK);
    }



}
