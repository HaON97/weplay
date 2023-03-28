import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import {Header, Main, Footer} from './layouts/common/';
import Party from './layouts/party';
import Guild from './layouts/guild';
import styled from 'styled-components';
import SideNav from './components/SideNav';

const Layout = styled.div`
  display: flex;
  justify-content: space-between;
  color: #a7a9be;
  font-size: 1.5rem;
  font-family: sans-serif;
`;

const Original = styled.div`
  display:flex;
  flex-direction:column;
  width:100%;
`

const App = () => {
  return (
    <div className="App">
      <Layout>
        <SideNav />
        <Original>
        <Header/>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Main/>}/>
            <Route path="/main" element={<Main/>}/>
            <Route path="/guild" element={<Guild/>}/>
            <Route path="/party" element={<Party/>}/>
          </Routes>
        </BrowserRouter>
        <Footer/>  
        </Original>
      </Layout>
      
    </div>
  );
}

export default App;
