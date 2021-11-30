import React from "react";
import NavigationSidebar from "./NavigationSidebar";
import WhoToFollowListItem from "./WhoToFollowList/WhoToFollowListItem";
import PostSummaryItem from "./PostSummaryList/PostSummaryItem";

const Build = () => {
    return(
        <>
            <div className="container">
                <div className="row">
                    <div className ="col-2">
                        <NavigationSidebar active="home"/>
                    </div>
                    <div className="col-5">
                        <PostSummaryItem/>
                    </div>

                    <div className ="col-4">
                        <WhoToFollowListItem/>
                    </div>
                </div>
            </div>
        </>
)
};
export default Build;
