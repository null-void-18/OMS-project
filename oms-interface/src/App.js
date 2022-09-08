import './App.css';
import Header from './oms-frontend/Home/Home';
import Products from './oms-frontend/Products/Product';
import Storesearch from './oms-frontend/Store/Storesearch';
import {BrowserRouter as Router,Routes,Route,Link} from "react-router-dom"
import Footer from "./oms-frontend/Footer/Footer"
import ErrorPage from './oms-frontend/Home/ErrorPage';
import Ordersearch from './oms-frontend/Order/Ordersearch';
import OrderItems from './oms-frontend/Order/Orderdetails';

function App() {
  return (
    <div className="App">
      <Router>
            <nav id="nav">
                <h1 id="main"><Link to="/">ABC.com</Link></h1>
                <ul id="list">
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/store">Stores</Link></li>
                    <li><Link to="/order">Orders</Link></li>
                </ul>
            </nav>
            <Routes>
                <Route path="/" element={<Header/>} />
                <Route path="/store" element={<Storesearch/>} />
                <Route path="/order" element={<Ordersearch/>} />
                <Route path="/store/product/:id" element={<Products/>} />
                <Route path="/order/item/:id" element={<OrderItems/>} />
                <Route path="*" element={<ErrorPage/>}/>
            </Routes>
        </Router>
        <div>
            <Footer/>
        </div>
    </div >
  );
}

export default App;
