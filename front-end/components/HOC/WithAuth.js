import { useRouter } from "next/router";
import { useAuth } from "../../pages/context/AuthContext";

const withAuth = Component => {
    const Auth = (props) => {
      const router = useRouter();
    
      // Login data added to props via redux-store (or use react context for example)
    //   const { currentUser } = props;

    const { currentUser } = useAuth();

    //   currentUser = useAuth();
  
      // If user is not logged in, return login component
      if (!currentUser) {
        router.replace('/auth/login')
        return null;
      }
  
      // If user is logged in, return original component
      return (
        <Component {...props} />
      );
    };
  
    // Copy getInitial props so it will run as well
    if (Component.getInitialProps) {
      Auth.getInitialProps = Component.getInitialProps;
    }
  
    return Auth;
  };
  
  export default withAuth;