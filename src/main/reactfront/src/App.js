import React from 'react';
import axios from 'axios';


function App() {
  //const cheerio = require('cheerio');
  // https://timeline.onstove.com/159967896
  const resp = axios.get("/test");
  //const $ = cheerio.load();
  console.log(resp);

  return (
    <div className="App">
      <div>Hello</div>
    </div>
  );
}

export default App;
