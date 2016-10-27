package mingjian.com.kendo.Model.Source;

import java.util.List;

/**
 * Created by studio02 on 10/27/16.
 */

public class AndroidResult {


    /**
     * error : false
     * results : [{"_id":"58103fc2421aa913769745c6","createdAt":"2016-10-26T13:31:46.696Z","desc":"Android app 增量更新。","images":["http://img.gank.io/bddae17e-7183-44de-97d7-acf6ed5a1a0c"],"publishedAt":"2016-10-27T11:41:45.88Z","source":"chrome","type":"Android","url":"https://github.com/kingwang666/AppAddUpdate","used":true,"who":"kingwang"},{"_id":"58105477421aa90e799ec213","createdAt":"2016-10-26T15:00:07.731Z","desc":"可设置圆角背景边框的的按钮","images":["http://img.gank.io/82378ff5-b30d-4a57-ac75-4250d71b77fd"],"publishedAt":"2016-10-27T11:41:45.88Z","source":"web","type":"Android","url":"https://github.com/czy1121/roundbutton","used":true,"who":"ezy"},{"_id":"581073c2421aa91369f95992","createdAt":"2016-10-26T17:13:38.464Z","desc":"让你的 App 不再那么无聊和单调，气泡风格的过渡动画效果，酷酷的！（老外投稿）","images":["http://img.gank.io/48064ba8-51f4-4732-86e2-25353d4eced2"],"publishedAt":"2016-10-27T11:41:45.88Z","source":"web","type":"Android","url":"https://github.com/Cleveroad/BubbleAnimationLayout","used":true,"who":null},{"_id":"5810bf67421aa90e6f21b458","createdAt":"2016-10-26T22:36:23.287Z","desc":"一个功能强大的TextView，可以满足日常大部分布局方式","images":["http://img.gank.io/4bde91e7-03ff-478f-bf82-ebc21dbd8ad4"],"publishedAt":"2016-10-27T11:41:45.88Z","source":"chrome","type":"Android","url":"https://github.com/lygttpod/SuperTextView","used":true,"who":"Jason"},{"_id":"5810c6cc421aa90e6f21b459","createdAt":"2016-10-26T23:07:56.851Z","desc":"Android进程绝杀技","publishedAt":"2016-10-27T11:41:45.88Z","source":"web","type":"Android","url":"http://gityuan.com/2016/10/22/force-stop/","used":true,"who":"Pan HongJin"},{"_id":"5811754b421aa90e6f21b463","createdAt":"2016-10-27T11:32:27.285Z","desc":"一款轻量级的文件选择器，支持多种文件类型","images":["http://img.gank.io/35553301-3def-40f8-81f1-a853e0aa0987","http://img.gank.io/190fe2c8-5ab4-4c61-b906-187d6b7ee35f"],"publishedAt":"2016-10-27T11:41:45.88Z","source":"web","type":"Android","url":"https://github.com/fishwjy/MultiType-FilePicker","used":true,"who":"Vincent"},{"_id":"580ff3fd421aa913769745bb","createdAt":"2016-10-26T08:08:29.661Z","desc":"高仿微信视差手势滑动返回，无需设置透明主题","images":["http://img.gank.io/2873a863-09ce-4581-91bc-5707d9b3a993"],"publishedAt":"2016-10-26T11:28:10.759Z","source":"web","type":"Android","url":"https://github.com/oubowu/SlideBack","used":true,"who":"Ou Bowu"},{"_id":"5810045f421aa90e799ec20a","createdAt":"2016-10-26T09:18:23.339Z","desc":"基于 DNS 实现的 Android 广告拦截","images":["http://img.gank.io/4f10467a-99a2-4429-9d45-eaa775818756"],"publishedAt":"2016-10-26T11:28:10.759Z","source":"chrome","type":"Android","url":"https://github.com/julian-klode/dns66","used":true,"who":"代码家"},{"_id":"581006bd421aa91369f95984","createdAt":"2016-10-26T09:28:28.930Z","desc":"开源的 Android APM （应用性能监测） 工具","images":["http://img.gank.io/f2519838-efb6-4d36-9b3e-a0cf9dd09dd3"],"publishedAt":"2016-10-26T11:28:10.759Z","source":"chrome","type":"Android","url":"https://github.com/scouter-project/scouter","used":true,"who":"代码家"},{"_id":"58102049421aa913769745c0","createdAt":"2016-10-26T11:17:29.981Z","desc":"Material Design 中那些标准的设计常量","publishedAt":"2016-10-26T11:28:10.759Z","source":"chrome","type":"Android","url":"https://github.com/AoDevBlue/MaterialValues","used":true,"who":"Ao"}]
     */

    private boolean error;
    /**
     * _id : 58103fc2421aa913769745c6
     * createdAt : 2016-10-26T13:31:46.696Z
     * desc : Android app 增量更新。
     * images : ["http://img.gank.io/bddae17e-7183-44de-97d7-acf6ed5a1a0c"]
     * publishedAt : 2016-10-27T11:41:45.88Z
     * source : chrome
     * type : Android
     * url : https://github.com/kingwang666/AppAddUpdate
     * used : true
     * who : kingwang
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public class ResultsBean extends BaseBean{
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
