import axios from "axios";

const ENDPOINT = 'http://localhost:8080/burgers';

class DataService {
    getData() {
        return axios.get(ENDPOINT);
    }
}

export default new DataService();