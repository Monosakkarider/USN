import {createBrowserRouter, RouterProvider, Outlet} from 'react-router-dom'
import Home from './pages/Home/Home'
import Category from './pages/Category/Category'
import Product from './pages/Product/Product'
import Header from './components/Header/Header'
import Footer from './components/Footer/Footer'
import RequestImport from './pages/RequestImport/RequestImport'
import Contact from './pages/Contact/Contact'
import Registrer from './pages/Registrer/Registrer'
import FooterLinks from './pages/FooterLinks/FooterLinks'
import TilKassen from './pages/TilKassen/TilKassen'
import TakkForHandel from './pages/TakkForHandel/TakkForHandel'
import Login from './pages/Login/Login'
import AdminPage from './pages/AdminPage/adminPage'
import CrudAccess from './pages/Crud/crudAccess'
import { CartProvider } from "react-use-cart";
import './global.css'

const Layout = () => {
  return (
    <div className ="app">
      <Header />
      <Outlet />
      <Footer />
    </div>
  )
}


const router = createBrowserRouter([
  {
    path:"/",
    element:<Layout />,
    children: [
      {
        path:"/",
        element:<Home />
      },
      {
        path:"/category/:catID",
        element:<Category />
      },
      {
        path:"/product/:id",
        element:<Product />
      },
      {
        path:"/requestImport",
        element:<RequestImport />
      },
      {
        path:"/contact",
        element:<Contact />
      },
      {
        path:"/registrer",
        element:<Registrer />
      },
      {
        path:"/aboutus",
        element:<FooterLinks />
      },
      {
        path:"/tilKassen",
        element:<TilKassen />
      },
      {
        path:"/takkForHandel",
        element:<TakkForHandel />
      },
      {
        path:"/login",
        element:<Login />
      },
      {
        path:"/adminPage",
        element:<AdminPage />
      },
      {
        path:"/crudAccess",
        element:<CrudAccess />
      }
      
    ],
  },


])


function App() {
  return (
    <div>
      <CartProvider>
        <RouterProvider router = {router} />
      </CartProvider>
    </div>
  );
}

export default App;