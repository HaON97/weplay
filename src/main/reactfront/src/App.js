import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import {Header, Main, Footer} from './layouts/common/';
import Party from './layouts/party';
import Guild from './layouts/guild';
import {SignUp, SignIn} from './layouts/profile/';

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
          <Route path="/signUp" element={<SignUp/>}/>
          <Route path="/signIn" element={<SignIn/>}/>
        </Routes>
      </BrowserRouter>
      <Footer/>
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
