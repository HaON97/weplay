import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import {SideNavbar, Header, Main, Footer} from './layouts/common/';
import Party from './layouts/party';
import Guild from './layouts/guild';

const App = () => {
  return (
    <div className="App">
      <Header/>
      <BrowserRouter>
        <SideNavbar/>
        <Routes>
          <Route path="/" element={<Main/>}/>
          <Route path="/main" element={<Main/>}/>
          <Route path="/guild" element={<Guild/>}/>
          <Route path="/party" element={<Party/>}/>
        </Routes>
      </BrowserRouter>
      <Footer/>
    </div>
  );
}

export default App;
