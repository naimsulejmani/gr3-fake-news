class NewsApi {
    constructor() {
        this.baseUrl = '/api/v1/news';
    }

    async getNews() {
        const response = await fetch(this.baseUrl);
        return response.json();
    }

    async getNewsById(id) {
        const response = await fetch(`${this.baseUrl}/${id}`);
        return response.json();
    }

    async deleteNewsById(id) {
        const response = await fetch(`${this.baseUrl}/${id}`, {
            method: 'DELETE'
        });
        return response.status === 204 ? "News deleted successfully" : "News not found";
    }

    // getNews() {
    //     return fetch(this.baseUrl)
    //         .then(response => response.json());
    // }
}