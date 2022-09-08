import React, { useState } from "react"
import axios from "axios"
import "./Ordersearch.css"
import {Link} from "react-router-dom"

function Ordersearch() {
    const [users, setUsers] = useState([{}])
    const [id, setId] = useState("")

    const handle = () => {
        axios.get(`http://localhost:8081/order/status/${id}`)
        .then((res) => {
            console.log(res)
            setUsers(res.data)
        })
        .catch((err) => {
            console.log(err)
        })
    }
    
    const displayData = (items) => {
        return ( 
            <tr>
            <td><Link to={`/order/item/${items.orderId}`}>
                {items.orderId}
                </Link>
            </td>
            <td>
                {items.orderStatus}
            </td>
            <td>
                {items.price}
            </td>
        </tr>
        )
    }

    return (
        <div>
            <div className="container">
                <b>Enter Order Status</b><input id="input" type="text" value={id} onChange={e => setId(e.target.value)}></input>
                {(id.trim() && isNaN(+id)) ? <button onClick={handle}>Search</button> : <button disabled>Search</button>}
            </div>
            <div className="tabl">
                <table className="t">
                    <thead>
                        <tr>
                            <td scope="col"><strong>Order ID</strong></td>
                            <td scope="col"><strong>Order Status</strong></td>
                            <td scope="col"><strong>Total Amount</strong></td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map(displayData)
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default Ordersearch;