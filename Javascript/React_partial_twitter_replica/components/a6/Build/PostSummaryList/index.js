import PostSummaryItem from "../PostSummaryList/PostSummaryItem.js";
import posts from "./post.json";
import React from "react";

const PostSummaryList = () => {
    return (
            <ul className="list-group">
              {
                  posts.map(post => {
                        return(
                            <PostSummaryItem post={post}/>
                        );
                    })
                }
        </ul>
); }

export default PostSummaryList;
