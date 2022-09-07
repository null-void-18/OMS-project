import React, { useState } from "react"
import axios from "axios"
import "./Ordersearch.css"

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
    

    return (
        <div>
            <div className="container">
                <b>Enter Order Status</b><input id="input" type="text" value={id} onChange={e => setId(e.target.value)}></input>
                {(id.trim() && isNaN(+id)) ? <button onClick={handle}>Search</button> : <button disabled>Search</button>}
            </div>
            <div className="result">
                {
                    users.map((items)=>
                    <div>
                        {
                            (items.orderitems)?
                            items.orderitems.map((info)=>
                            <div>
                                {info.product.productName}
                            </div>
                            )
                            :
                            null
                        }
                    </div>
                    )
                }
                <h4>{users[0].orderId}</h4>
            </div>
        </div>
    )
}

export default Ordersearch;