import React from 'react';
import Comment from './comment';
import Likes from './like';
const client = require('../client');

class Post extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
        comments: []
    };
    this.getComments = this.getComments.bind(this);
    this.id = this.props.post._links.self.href.split("/")[this.props.post._links.self.href.split("/").length-1];

  }

  componentDidMount() {
    client({method: 'GET', path: '/api/comments/search/findByPostid?post_id=' + this.id}).then(response => {
      this.setState({comments: response.entity._embedded.comments});
    });
  }

render () {
	return (

     	<div className='post-main'>
            <div className='post-content'>
                {this.props.post.content.split("\n").map((i,key) => {return <div key={key}>{i}</div>;})}
            </div>
            <div className='post-time'>
                {this.props.post.timestamp}
            </div>
            <p></p>
            <h5>Comments</h5>
            <div className='comments-item'>
                {this.getComments()}
            </div>
            <a href={"post/"+this.id+"/comment"}>Comment</a>
            <br />
            <Likes likes={this.props.post.likes}/>
        </div>
	  )
    }

     getComments() {
        return this.state.comments.map(comment =>
    			<Comment key={comment._links.self.href} comment={comment}/>

    		);
      }
}


export default Post;


