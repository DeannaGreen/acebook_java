import React from 'react';

class Likes extends React.Component {

  constructor(props){

    super(props);
    this.state = {
      likes: 0,
      updated: false
    };

    this.Likes= this.updateLikes.bind(this);

  }

  updateLikes() {

    if(!this.state.updated) {
      this.setState((prevState, props) => {
        return {
          likes: prevState.likes + 1,
          updated: true
        };
      });

    } else {

      this.setState((prevState, props) => {
        return {
          likes: prevState.likes - 1,
          updated: false
        };
      });

    }
  }

  render(){

    return(
      <div>
        <button onClick={this.Likes}>Like: {this.state.likes}</button>
      </div>
    );
  }
}

export default Likes;
