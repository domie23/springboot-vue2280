const base = {
    get() {
        return {
            url : "http://localhost:8080/yuneifengxianpinggu/",
            name: "yuneifengxianpinggu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yuneifengxianpinggu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "狱内罪犯危险性评估系统"
        } 
    }
}
export default base
