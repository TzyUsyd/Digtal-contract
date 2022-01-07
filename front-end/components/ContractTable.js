import React, { useState,useEffect} from 'react';
import { Table, Tag, Space } from 'antd';

const axios = require('axios').default;



const data1 = [
    {
        key: '1',
        partyA: 'John Brown',
        partyB: 'Hunter Xu',
        date: '2021-10-25',
        tags: ['normal'],
        type: 'IOU'
    },
    {
        key: '2',
        partyA: 'Jim Green',
        partyB: 'Hunter Xu',
        date: '2021-10-25',
        tags: ['normal'],
        type: 'IOU'
    },
    {
        key: '3',
        partyA: 'Joe Black',
        partyB: 'Hunter Xu',
        date: '2021-10-25',
        tags: ['normal'],
        type: 'IOU'
    },
];

export default function ContractTable() {
    const [data, setData] = useState('');

    useEffect(() => {
        axios.get('http://localhost:8080/contract/2')
        .then(function (response) {
            // handle success
            console.log(response);
            setData(response.data);
        })
        .catch(function (error) {
            // handle error
            console.log(error);
        })
        .then(function () {
            // always executed
        });
    }, [])
    

    const columns = [
        {
            title: 'ID',
            dataIndex: 'contractId',
            key: 'contractId',
            render: text => <a>{text}</a>,
        },
        {
            title: 'Type',
            key: 'type',
            dataIndex: 'type',
            render: type => {
                let color = 'geekblue'
                return (
                    <Tag color={color}>
                        {type}
                    </Tag>
                );
            }
        },
        {
            title: 'Party A',
            dataIndex: 'partyA',
            key: 'partyA',
        },
        {
            title: 'Party B',
            dataIndex: 'partybName',
            key: 'partybName',
        },
        {
            title: 'Begin Date',
            dataIndex: 'beginDate',
            key: 'beginDate',
        },
        {
            title: 'End Date',
            dataIndex: 'endDate',
            key: 'endDate',
        },
        {
            title: 'Action',
            key: 'action',
            render: (text, record) => (
                <Space size="middle">
                    {/* <a>Invite</a> */}
                    <a>Delete</a>
                </Space>
            ),
        },
    ];
    return (
        <Table columns={columns} dataSource={data} style={{ margin: '5% auto', width: '100%' }} />
    )
}