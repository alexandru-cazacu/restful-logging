import React from "react";

class Form extends React.Component {

    constructor(props) {
        super(props);

        this.state = { filter: "" };
    }

    handleChange(e) {
        this.setState({filter: e.target.value});
        console.log(e.target.value);
    }

    handleSearch(e) {
        this.props.handleSearch(this.state.filter);
    }

    render() {
        return (
            <div className="card">
                <input value={this.state.filter} type="text" name="appId" id="appId" placeholder="App ID..." onChange={this.handleChange.bind(this)} />
                <select name="level" id="level">
                    <option value="All">All</option>
                    <option value="INFO">INFO</option>
                    <option value="SEVERE">SEVERE</option>
                    <option value="FINE">FINE</option>
                    <option value="FINER">FINER</option>
                </select>
                <button className="bg-primary-blue primary-white" onClick={this.handleSearch.bind(this)}>Filter</button>
            </div>
        );
    }
}

export default Form;