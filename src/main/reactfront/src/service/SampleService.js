import axios from 'axios';

const CRAWLING_URL = "http://localhost:8080/crawl/getCertifiedCode";

class SampleService{

    getList(){
        return axios.get(CRAWLING_URL);
    }
  
}

export default new SampleService();