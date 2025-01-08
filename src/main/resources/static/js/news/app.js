class NewsApp {
    constructor() {
        this.newsApi = new NewsApi();
        this.newsListDiv = document.getElementById("newsList");
        this.loaderDiv = document.getElementById("loader");
        this.news = [];
        this.body = document.querySelector("body");
        this.btnRefresh = document.getElementById("btnRefresh");

    }

    async init() {
        this.loadNews();
        this.newsListDiv.addEventListener("click", async (event) => {

            if (event.target.tagName === 'BUTTON' && event.target.innerText === 'Delete') {

                if (!confirm("Are you sure you want to delete this news?")) {
                    return;
                }

                console.log(event);
                console.log(event.target);
                console.log(event.target.dataset);
                const {id, archived} = event.target.dataset; //destructuring

                await this.newsApi.deleteNewsById(id);
                this.loadNews();


            }
        })

        this.btnRefresh.addEventListener("click", async(event)=>{
            this.loadNews();
        })
    }

    async loadNews() {
        this.newsListDiv.style.display = "none";
        this.loaderDiv.style = {display: "block"}; //"display: 'block'"

        this.news = await this.newsApi.getNews();

        this.displayNews();
        this.loaderDiv.style.display = "none";
        this.newsListDiv.style.display = "block";


    }

    displayNews() {
        this.newsListDiv.innerHTML = "";

        console.log(this.news)
        if (!this.news.length) {
            this.newsListDiv.innerHTML = `<h1>There are no news</h1>`;
        }

        this.news.forEach(news => {
            this.newsListDiv.innerHTML += `
         <div class="col-sm-6 mb-3 mb-sm-0">
            <div class="card">
                <div class="card-body">
                   
                    <h5 class="card-title">#${news.id} - ${news.title}</h5>
                    <p class="card-text">${news.description.substring(0, 100) + '...'}</p>
                    <a href="${news.url}" class="btn btn-primary">Go to article news</a>
                    <button type="button" class="btn btn-warning" style="float:right; margin-right: 5px;">Edit</button>
                    <button type="button" class="btn btn-danger" style="float:right;margin-right: 5px;"
                    data-id="${news.id}" data-archived="${news.archived}">Delete</button>
                </div>
            </div>
        </div>
            `;
        });
    }

}

// new NewsApp().init();
const newsApp = new NewsApp();
newsApp.init()
    .then(() => {
        console.log("JAVA SCRIPT LOADED SUCCESSFULLY")
    });