import React from 'react';

class Likes extends React.Component {

  constructor(props){

    super(props);
    this.state = {
      likes: this.props.likes,
      updated: false,
      btn_class: "btn btn-light"
    };

    this.Likes= this.updateLikes.bind(this);

  }

  updateLikes() {

    if(!this.state.updated) {
      this.setState((prevState, props) => {
        return {
          likes: prevState.likes + 1,
          updated: true,
          btn_class: "btn btn-primary"
        };
      });
      changeColor();

    } else {

      this.setState((prevState, props) => {
        return {
          likes: prevState.likes - 1,
          updated: false,
          btn_class: "btn btn-light"
        };
      });

    }
  }

  render(){

    return(
      <div>
        <button onClick={this.Likes} className={this.state.btn_class}>Likes: {this.state.likes}</button>
      </div>
    );
  }
}

export default Likes;
