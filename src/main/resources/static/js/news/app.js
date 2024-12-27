class NewsApp {
    constructor() {
        this.newsApi = new NewsApi();
        this.inputTitle = document.getElementById("title");
        this.buttonShowNews = document.getElementById("showNews")
        this.buttonDeleteNews = document.getElementById("deleteNews")
    }

    async init() {
        this.inputTitle.focus();

        this.buttonShowNews.addEventListener("click", async() => {
            if(!this.inputTitle.value)
                await this.loadNews();
            else {
                const news = await this.newsApi.getNewsById(this.inputTitle.value);
                console.log(news);
            }
        })

        this.buttonDeleteNews.addEventListener("click", async() => {
            if(!this.inputTitle.value)
                alert("Please enter a title to delete");
            else {
                const news = await this.newsApi.deleteNewsById(this.inputTitle.value);
                console.log(news);
            }
        });

    }

    async loadNews() {
        const news = await this.newsApi.getNews();
        console.log(news);
    }
}

// new NewsApp().init();
const newsApp = new NewsApp();
newsApp.init()
    .then(() => {
        console.log("JAVA SCRIPT LOADED SUCCESSFULLY")
    });