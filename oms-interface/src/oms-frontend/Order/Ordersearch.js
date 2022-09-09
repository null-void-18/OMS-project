import React, { useState, useEffect } from "react"
import axios from "axios"
import "./Ordersearch.css"
import { Link } from "react-router-dom"

function Ordersearch() {
    const [users, setUsers] = useState([{}])
    const [id, setId] = useState("")
    const [sortType, setSortType] = useState('orderId');

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

    useEffect(() => {
        const sortArray = type => {
            const types = {
                orderId: 'orderId',
                orderDate: 'orderDate',
                price: 'price',
                orderStatus: 'orderStatus',
            };
            const sortProperty = types[type];
            var sorted = []
            if (sortProperty === 'orderDate') {
                sorted = [...users].sort((a, b) => {
                    const [date, month, year] = a.orderDate.split('/');
                    const isoStr = `${year}-${month}-${date}`
                    const [d, m, y] = b.orderDate.split('/');
                    const isoStr1 = `${y}-${m}-${d}`
                    return new Date(isoStr1) - new Date(isoStr)
                }
                )
            }
            else if (sortProperty === 'orderStatus') {
                sorted = [...users].sort((a, b) => b.orderStatus.localeCompare(a.orderStatus))
            }
            else if(sortProperty === 'orderId') {
                sorted = [...users].sort((a,b) => a.orderId - b.orderId)
            }
            else {
                sorted = [...users].sort((a, b) => b[sortProperty] - a[sortProperty]);
            }
            setUsers(sorted);
        };
        sortArray(sortType);
    }, [sortType]);

    const displayData = (items) => {
        return (
            <tr>
                <td><Link to={`/ order / item / ${ items.orderId }`}>
                    {items.orderId}
                </Link>
                </td>
                <td>
                    {items.orderStatus}
                </td>
                <td>
                    {items.orderDate}
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
                <select onChange={(e) => setSortType(e.target.value)}>
                    <option value="orderId">Order ID</option>
                    <option value="orderDate">Order Date</option>
                    <option value="price">Price</option>
                    <option value="orderStatus">Order Status</option>
                </select>
            </div>

            <div className="tabl">
                <table className="table">
                    <thead>
                        <tr>
                            <td scope="col"><strong>Order ID</strong></td>
                            <td scope="col"><strong>Order Status</strong></td>
                            <td scope="col"><strong>Ordered Date</strong></td>
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