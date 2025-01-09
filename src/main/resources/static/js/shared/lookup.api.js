class LookupApi {
    constructor() {
        this.baseUrl = '/api/v1/lookup';
    }

    async getCategories() {
        const response = await fetch(`${this.baseUrl}/categories`);
        return response.json();
    }
}