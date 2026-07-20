import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {

  constructor(props) {
    super(props);

    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => {
        const posts = data.map(
          (item) =>
            new Post(item.userId, item.id, item.title, item.body)
        );

        this.setState({
          posts: posts
        });
      })
      .catch((error) => {
        throw error;
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An Error Occurred: " + error);
    console.error(error, info);
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>

        {this.state.posts.map((post) => (
          <div
            key={post.id}
            style={{
              border: "1px solid gray",
              padding: "15px",
              margin: "10px"
            }}
          >
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;