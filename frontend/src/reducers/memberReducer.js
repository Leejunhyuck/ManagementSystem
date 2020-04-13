const initalState = {user:{userid:'user00', userpw:'p2',username:'홍길동',state:false}}

function memberReducer(state = initalState, action) {

    console.log('memberReducer...', state,action)

    const {type,payload} = action

    if(type === 'SUCCESS_LOGIN'){
        return {
            ...state,
            user: payload,
            state:true
        }
    }
    
    return state
}

export default memberReducer