import React from "react";
import who from "./who.json";

const WhoToFollowListItem = (    {
                                     who = {
                                         avatarIcon: 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/NASA_Wormball_logo.svg/512px-NASA_Wormball_logo.svg.png',
                                         userName: 'NASA',
                                         handle: 'NASA',
                                     }
                                 }
) => {return(
                <div>
                        <div className = "list-group-item">
                        <div className = "row">
                            <div className = "col-3">
                                <img className = "img-thumbnail" height = "100px" width = "100px" src = {who.avatarIcon}/>
                            </div>
                            <div className = "col-6">
                                <div className = "container" >
                                    <div className = "row">
                                        <div className = "align-items-start col">
                                            <span className = "fw-bold"><small> {who.userName} </small>
                                        <i className= "fas fa-check-circle"></i>
                                        </span>
                                        </div>
                                    </div>
                                    <div className = "row">
                                        <div className = "col">
                                        <span className = "text-muted">{who.handle} </span>
                                    </div>
                                    </div>
                                </div>
                            </div>
                            <div className = "col-3">
                    <div className="follow-override btn btn-primary"> Follow </div>
                    </div>
                </div>
                </div>
            </div>
    );
    }

export default WhoToFollowListItem;