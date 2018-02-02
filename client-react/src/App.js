import React, { Component } from 'react';
import axios from "axios";
import "./proto.css";

class App extends Component {

  constructor(props) {
    super(props);

    this.state = {table: []};
  }

  componentDidMount() {
    axios.get("http://localhost:8888/api/logmessages", {
      crossdomain: true
    })
    .then((response) => {
      let res = [];
      res = response.data.map((value) => {

        let color;
        if (value.level === "SEVERE")
          color = "primary-red";
        else if (value.level === "INFO")
          color = "primary-blue";
        else if (value.level === "FINE")
          color = "primary-lime";
        else
          color="primary-black"

        return (
          <tr>
            <td>{value.timestamp}</td>
            <td>{value.appid}</td>
            <td>{value.message}</td>
            <td className={color}>{value.level}</td>
          </tr>
        );
      });
      this.setState({table: res});
      console.log(response);
    })
    .catch((error) => {
      
    })
  }

  render() {
    return (
      <div className="wrapper">
      <div className="space"></div>
      <h1><center>RESTful Logger</center></h1>
      <div className="space"></div>
        <table className="proto-table striped filled center v-border">
          <tbody>
            <tr>
              <th>Time</th>
              <th>APPID</th>
              <th>Message</th>
              <th>Level</th>
            </tr>
          </tbody>
          <tbody>
            {this.state.table}
          </tbody>
        </table>
      </div>
    );
  }
}

export default App;
