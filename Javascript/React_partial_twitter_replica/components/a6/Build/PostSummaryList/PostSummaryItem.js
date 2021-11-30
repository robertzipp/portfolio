import React from "react";

const PostSummaryItem = ({ post =
    {
        topic: "Web Development",
        userName: "ReactJS",
        time: "2h",
        image: "https://iconape.com/wp-content/png_logo_vector/react-2.png",
        title: "React.js is a component based front end library that makes it very easy to build Single Page Applications or SPAs"
    }
        })  =>
    {return(   <li className="container list-group-item">
                        <div className = "row align-items-center">
                            <div className = "col-8">
                                <div className = "row">
                                    <div className = "col">
                                        <p className = "text-muted">
                                            <small> {post.topic} </small>
                                        </p>
                                        <div className = "row">
                                            <div className = "col">
                                                <span className = "fw-bold"> {post.userName} </span>
                                                <i className= "fas fa-check-circle"></i>
                                                <span className = "text-muted">- {post.time}</span>
                                            </div>
                                        </div>
                                        <div className = "row">
                                            <div className = "col">
                                        <span className = "fw-bold">{post.title}</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                       <div className = "col-2">
                           <img className = "justify-content-end" height= "100px" width= "100px" src={post.image}/>
                       </div>
                         </div>
                    </li>
);
}

export default PostSummaryItem;