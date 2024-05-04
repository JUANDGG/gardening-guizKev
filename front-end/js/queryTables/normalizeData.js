

const reorganizationData =(data) =>{
    if (Array.isArray(data)) {
        if (data.length > 0) {
            if (typeof data[0] === 'object' && data[0] !== null) {
                return data.map(item => {
                    const newItem = {};
                    for (const key in item) {
                        if (item.hasOwnProperty(key)) {
                            if (typeof item[key] === 'object' && item[key] !== null) {
                                newItem[key + '_child'] = JSON.stringify(normalizeData(item[key]));
                            } else {
                                newItem[key] = item[key];
                            }
                        } 
                    }
                    return newItem;
                });
            } else {
                return data.map((value, index) => ({ index, value }));
            }
        } else {
            return [];
        }
    } else if (typeof data === 'object' && data !== null) {
        return Object.entries(data).map(([key, value]) => ({ key, value }));
    } else {
        return [{ value: data }];
    }
}


export {
    reorganizationData
}