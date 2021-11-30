import React from "react";
const NavigationSidebar = (
    {
        active = 'explore'
    }) =>  {
    return(
        <div>
            <ul className="list-group">
               <li className="list-group-item"> <i className="fab fa-twitter"></i> </li>
                    <li className="list-group-item d-flex align-items-center"> <i className="pe-1 fas fa-home"></i> <span className ="d-none d-xl-block" > Home </span> </li>
                    <li className="list-group-item active d-flex align-items-center"> <i className="pe-1 fas fa-hashtag"></i> <span className ="d-none d-xl-block" > Explore </span> </li>
                    <li className="list-group-item d-flex align-items-center"> <i className="pe-1 fas fa-bell"></i> <span className ="d-none d-xl-block" > Notifications </span> </li>
                    <li className="list-group-item d-flex align-items-center"> <i className="pe-1 fas fa-envelope"></i> <span className ="d-none d-xl-block" > Messages </span> </li>
                    <li className="list-group-item d-flex align-items-center"> <i className="pe-1 fas fa-bookmark"></i> <span className ="d-none d-xl-block" > Bookmarks</span> </li>
                    <li className="list-group-item d-flex align-items-center"> <i className="pe-1 fas fa-list"></i> <span className ="d-none d-xl-block" > Lists</span> </li>
                    <li className="list-group-item d-flex align-items-center"> <i className="pe-1 fas fa-user"></i> <span className ="d-none d-xl-block" > Profile</span> </li>
                    <li className="list-group-item d-flex align-items-center"> <i className="pe-1 fas fa-plus"></i> <span className ="d-none d-xl-block" > More</span></li>
                
            </ul>
                <div className="btn btn-primary btn-block rounded-pill">
                    Tweet</div>
        </div>
    );
}
export default NavigationSidebar;
