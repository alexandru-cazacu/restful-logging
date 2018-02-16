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
                <input value={this.state.filter} type="text" name="appId" id="appId" placeholder="Log Level..." onChange={this.handleChange.bind(this)} />
                <button className="bg-primary-blue primary-white" onClick={this.handleSearch.bind(this)}>Filter</button>
            </div>
        );
    }
}

export default Form;