import React, { Component } from "react";

class Getuser extends Component {

  constructor(props) {
    super(props);

    this.state = {
      title: "",
      firstName: "",
      picture: ""
    };
  }

  async componentDidMount() {

    const response = await fetch("https://api.randomuser.me/");
    const data = await response.json();

    this.setState({
      title: data.results[0].name.title,
      firstName: data.results[0].name.first,
      picture: data.results[0].picture.large
    });
  }

  render() {

    return (

      <div style={{ textAlign: "center", marginTop: "30px" }}>

        <h1>User Details</h1>

        <img
          src={this.state.picture}
          alt="User"
          width="200"
          height="200"
          style={{ borderRadius: "50%" }}
        />

        <h2>
          {this.state.title} {this.state.firstName}
        </h2>

      </div>

    );

  }

}

export default Getuser;