import React from "react";
import WhoToFollowListItem from
        "./WhoToFollowListItem";


const WhoToFollowList = () => {
    return (
            <ul className="list-group">
        <div className = "list-group-item">
        Who to Follow
        </div>
                {
                   who.map(who => {
                        return(
                            <WhoToFollowListItem who={who}/>
                        );
                    })
                }


            </ul>
); }

export default WhoToFollowList;
