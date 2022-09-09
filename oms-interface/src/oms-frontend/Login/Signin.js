import React from "react";
import axios from "axios"
import "./LoginForm.css"
import {Link} from "react-router-dom"

class Signin extends React.Component {
    constructor(props) {
        super()

        this.state = {
            display: false,
            customerName: '',
            email: '',
            password: "",
            error: false
        }
    }

    handle = (e) => {
        this.setState({ [e.target.name]: e.target.value })
    }

    handler = (e) => {
        e.preventDefault()
        console.log(this.state)
        axios.get(`http://localhost:8081/customer/${this.state.customerName}`)
            .then(res => {
                if (res.data.password == this.state.password){
                    this.setState({ display: true, error: false })
                }
                else{
                    this.setState({ error: true, display: false })
                    console.log("error")
                }
            })
            .catch(err => {
                this.setState({ display: false })
                this.setState({ error: true })
                console.log(err)
            })
    }

    render() {
        const { customerName, email, password } = this.state
        return (
            <div className="form">
                <div>
                    <h1>LOGIN</h1>
                </div>
                <div>
                    {this.state.display == true ? <label>LOGIN SUCCESS</label> : null}
                    {this.state.error == true ? <label>INCORRECT USERNAME OR PASSWORD</label> : null}
                </div>
                <form onSubmit={this.handler}>
                    <label className="label">Name</label>
                    <input onChange={this.handle} className="input" name="customerName"
                        value={customerName} type="text" />

                    <label className="label">Password</label>
                    <input onChange={this.handle} className="input" name="password"
                        value={password} type="password" /><br />

                    <button className="btn" type="submit">
                        Submit
                    </button><button className="btn"><Link to="/signup">SIGNUP</Link></button>
                </form>
            </div>
        )
    }
}

export default Signin