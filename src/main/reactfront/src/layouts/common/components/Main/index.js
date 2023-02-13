import axios from 'axios';

function test() {
    // 'http://localhost:8080/test/testMethod'
    axios.post('http://localhost:8080/test/testMethod',{
    	pkey:"15695165465"
    })
    .then((response) => {
        console.log(response.data);		//정상 통신 후 응답된 메시지 출력
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
        </div>
    );
}

export default Main;