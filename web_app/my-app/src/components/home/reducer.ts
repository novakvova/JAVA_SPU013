import { ICategoryItem, CategoryActionType } from './types';

const initState: Array<ICategoryItem> = [
    // {
    //     id: 1,
    //     name: "Сало",
    //     description: "Смачно і корисно",
    //     image: "https://cdn.standardmedia.co.ke/sdemedia/sdeimages/wednesday/vqxglytud1pip3r6010f6744ef8f.jpg"
    // }
];

export const CategoryReducer = (state=initState, action: any) => {
    //console.log("action", action);
    switch(action.type) {
        
        case CategoryActionType.GET_CATEGORIES: {
            const payload : Array<ICategoryItem> = action.payload as [];
            return payload;
        }
    }
    return state;
} 