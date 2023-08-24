const React = require('react');
const {useState, useEffect} = require('react');
const { Link,useParams } = require('react-router-dom');
const client = require('../client');

const NuevoDetalleVentaPage = () => {

    let { id } = useParams();

    
    const [productos, setProductos] = useState([])

    const [idProducto, setIdProducto] = useState('')

    const handleSubmit = (evento)=>{
        evento.preventDefault();
        client({
            method: 'POST',
            path: '/api/detalleventas',
            entity: {
                venta: 'http://localhost:8080/api/ventas/'+id,
              
                producto: 'http://localhost:8080/api/productos/'+idProducto},
            headers: {'Content-Type': 'application/json'}
        }).done(()=>{
           window.location = '/';
        })
    }

    useEffect(() => {
        client({
            method: 'GET',
            path: '/api/productos'
        }).done(response=>{
            setProductos(response.entity._embedded.productos)
        })

    },[])

    return (
        <>
            <h1>Nuevo Detalle Venta</h1>
            <form onSubmit={handleSubmit}>

                
                <label>Producto </label>
                <select name="producto" id="producto" onChange={(e)=>{setIdProducto(e.target.value)}}>
                    {productos.map(producto => {	
                        const value = producto._links.self.href.split('/').slice(-1)
                        return (
                            <option key={value} value={value}>({producto.nombre})</option>
                        )
                    })}
                </select><br />

                <input type="submit" value="Nuevo Detalle Venta" />

            </form>
            <Link to="/">Volver</Link>
        </>
    )
}

module.exports = NuevoDetalleVentaPage;