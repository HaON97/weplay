import './App.css';
import {SideNavbar, Header, Main} from './layouts/common/';

const App = () => {
  return (
    <div className="App">
      <Header/>
      <Main/>
      <SideNavbar/>
    </div>
  );
}

export default App;
