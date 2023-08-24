const React = require('react');
const ReactDOM = require('react-dom');
const {createBrowserRouter, RouterProvider} = require('react-router-dom');

const HomePage = require('./pages/home');
const VerProductoPage = require('./pages/ver-producto');
const NuevoProductoPage = require('./pages/nuevo-producto');
const EditarProductoPage = require('./pages/editar-producto');
const VerVentaPage = require('./pages/ver-venta');
const NuevoDetalleVentaPage = require('./pages/nuevo-detalleVenta');


const router = createBrowserRouter([
	{ path: '/', element: <HomePage /> },
	{ path: '/ver-producto/:id', element: <VerProductoPage /> },
	{ path: '/nuevo-producto', element: <NuevoProductoPage /> },
	{ path: '/editar-producto/:id', element: <EditarProductoPage /> },
	{ path: '/ver-venta/:id', element: <VerVentaPage /> },
	{ path: '/ver-venta/:id/nuevo-detalleVenta', element: <NuevoDetalleVentaPage /> },


])


ReactDOM.render(
	<React.StrictMode>
		<RouterProvider router={router} />
	</React.StrictMode>,
	document.getElementById('react'))
