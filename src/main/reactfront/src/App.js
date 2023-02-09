import './App.css';
import SideNavbar from './layouts/common/components/SideNavbar';
import Header from './layouts/common/components/Header';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return (
    <div className="App">
      <Header/>
      <SideNavbar/>
    </div>
  );
}

export default App;
