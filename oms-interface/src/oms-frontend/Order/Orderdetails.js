import React from "react"
import axios from "axios"
import {  useState, useEffect } from "react"
import { useParams } from "react-router-dom"
import "./Ordersearch.css"

function OrderItems() {
    const { id } = useParams()
    const [users, setUsers] = useState([])

    useEffect(() => {
        axios.get(`http://localhost:8081/order/item/${id}`)
            .then((res) => {
                console.log(res)
                setUsers(res.data)
            })
            .catch((err) => {
                console.log(err)
            })
    }, [id])

    const displayData = (items) => {
        return (
            <tr>
                <td>
                    {items.product.productName}
                </td>
                <td>
                    {items.product.mdate}
                </td>
                <td>
                    {items.product.edate}
                </td>
                <td>
                    {items.product.cost}
                </td>
                <td>
                    {items.quantity}
                </td>
            </tr>
        )
    }

    return (
        <div>
            <div className="result">
                <h1>ITEMS IN ORDER</h1>
            </div>
            <div className="tabl">
                <table className="t">
                    <thead>
                        <tr>
                            <td scope="col"><strong>Product Name</strong></td>
                            <td scope="col"><strong>Mnf Date</strong></td>
                            <td scope="col"><strong>Exp Date</strong></td>
                            <td scope="col"><strong>Price</strong></td>
                            <td scope="col"><strong>Quantity</strong></td>
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

export default OrderItems