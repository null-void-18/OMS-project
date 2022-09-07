import axios from "axios"
import React, { useState } from "react"
import "./Storesearch.css"

function Storesearch() {
    const [users, setUsers] = useState({})
    const [id, setId] = useState("")

    const handle = () => {
        axios.get(`http://localhost:8081/store/${id}`)
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
                <b>Enter Store ID</b><input id="input" type="text" value={id} onChange={e => setId(e.target.value)}></input>
                {(id.trim() && !isNaN(+id)) ? <button onClick={handle}>Search</button> : <button disabled>Search</button>}
            </div>
            <div className="result">
                <table>
                    <thead>
                        <tr>
                            <td><strong>Shop Name</strong></td>
                            <td><strong>Email Id</strong></td>
                            <td><strong>Contact No</strong></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>{users.shopName}</td>
                            <td>{users.contactNumber}</td>
                            <td>{users.emailId}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default Storesearch;