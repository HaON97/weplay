import axios from 'axios';

function test() {
    // 'http://localhost:8080/test/testMethod'
    axios.post('http://localhost:8080/api/getApiKey')
    .then((response) => {

        console.log(response.data);		//정상 통신 후 응답된 메시지 출력
        console.log(response.data.data.apiKey);
        axios.post('http://localhost:8080/api/login/validation',{
            userURL : "https://timeline.onstove.com/159967896",
            userApiKey : response.data.data.apiKey,
            userMainChar : "하온Z"
        }).then((response)=>{
            console.log(response.data);
        });

    })
    .catch((error)=>{
        console.log(error);				//오류발생시 실행
})
}

const Main = () => {
    
    return (
        <div>
            Main
            <button onClick={test}>Test</button>
            <div></div>
        </div>
    );
}

export default Main;