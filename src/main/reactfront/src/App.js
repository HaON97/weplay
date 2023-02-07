import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import HeaderComponent from './components/common/HeaderComponent';
import FooterComponent from './components/common/FooterComponent';
import SampleComponent from './components/Sample';

function App() {

  return (
    <div>
      <Router>
        <HeaderComponent/>
          <div className='container'>
            <Routes>
              <Route path = "/" exact element = {<SampleComponent />}></Route>
            </Routes>
          </div>
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
