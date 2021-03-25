package com.example.myapplication41.model.Bean;

import java.util.List;

/**
 * 项目名： My Application41
 * 包名：   com.example.myapplication41.model.Bean
 * 文件名： BannerBean
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 16:53
 * 描述：TODO  一号GSON解析
 */
public class BannerBean {

    /**
     * errcode : 0
     * errmsg : 成功
     * data : {"list":[{"topic_id":1,"ad":2,"serviceType":3,"house_id":"","thumb":"http://img.zgsta.zhuge.com/xfcrm/2021-03-24/178a6eead249d4859fa792fa2df357a8.jpeg","url":"http://api.zhuge.com/newhouse/c?mid=24114&ct=1616601600&bi=4169&c=10112101104&pi=27299&u=Bu0a0sacC%2FOxmO0oRBbYhqx6ndcKIWF1VkrmwR3o3qgYFRxzr0MG77LdopZOBxyxdvQVVOzLmIreBCe2AvPJmQ%3D%3D","filter":[],"extra":{},"title":"北京恒大御峰","description":"北京恒大御峰"},{"topic_id":"1","serviceType":"3","ad":1,"url":"https://m.zhuge.com/news/bj/zhuanti/241796.html","extra":{},"house_id":"","filter":[],"thumb":"https://img.zgsta.zhuge.com/news/0318/1616054348158562538.jpg"},{"topic_id":"1","serviceType":"3","ad":1,"url":"https://wx.vzan.com/live/tvchat-203164731?v=1614820347645","extra":{},"house_id":"","filter":[],"thumb":"https://img.zgsta.zhuge.com/news/0304/1614826447161288923.jpg"},{"topic_id":"1","serviceType":"3","ad":1,"url":"https://m.zhuge.com/bj/xinfang/wangshangkanfang/eryue/","extra":{},"house_id":"","filter":[],"thumb":"https://img.zgsta.zhuge.com/news/0303/161476976947818516.jpg"}]}
     */

    private int errcode;
    private String errmsg;
    private DataBean data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * topic_id : 1
             * ad : 2
             * serviceType : 3
             * house_id :
             * thumb : http://img.zgsta.zhuge.com/xfcrm/2021-03-24/178a6eead249d4859fa792fa2df357a8.jpeg
             * url : http://api.zhuge.com/newhouse/c?mid=24114&ct=1616601600&bi=4169&c=10112101104&pi=27299&u=Bu0a0sacC%2FOxmO0oRBbYhqx6ndcKIWF1VkrmwR3o3qgYFRxzr0MG77LdopZOBxyxdvQVVOzLmIreBCe2AvPJmQ%3D%3D
             * filter : []
             * extra : {}
             * title : 北京恒大御峰
             * description : 北京恒大御峰
             */

            private int topic_id;
            private int ad;
            private int serviceType;
            private String house_id;
            private String thumb;
            private String url;
            private List<?> filter;
            private ExtraBean extra;
            private String title;
            private String description;

            public int getTopic_id() {
                return topic_id;
            }

            public void setTopic_id(int topic_id) {
                this.topic_id = topic_id;
            }

            public int getAd() {
                return ad;
            }

            public void setAd(int ad) {
                this.ad = ad;
            }

            public int getServiceType() {
                return serviceType;
            }

            public void setServiceType(int serviceType) {
                this.serviceType = serviceType;
            }

            public String getHouse_id() {
                return house_id;
            }

            public void setHouse_id(String house_id) {
                this.house_id = house_id;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<?> getFilter() {
                return filter;
            }

            public void setFilter(List<?> filter) {
                this.filter = filter;
            }

            public ExtraBean getExtra() {
                return extra;
            }

            public void setExtra(ExtraBean extra) {
                this.extra = extra;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public static class ExtraBean {
            }
        }
    }
}
