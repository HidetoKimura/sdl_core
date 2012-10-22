#ifndef __TRANSPORTMANAGER_CTRANSPORTMANAGER_HPP__
#define __TRANSPORTMANAGER_CTRANSPORTMANAGER_HPP__

#include "TransportManager/ITransportManager.hpp"
#include "Logger.hpp"

namespace AppLink
{
    namespace TransportManager
    {
        /**
         * @brief Transport manager implementation.
         **/
        class CTransportManager: public ITransportManager
        {
        public:
            /**
             * @brief Constructor.
             **/
            CTransportManager(void);

            /**
             * @brief Destructor.
             **/
            virtual ~CTransportManager(void);

            /**
             * @brief Run transport manager.
             *
             * Must be called from startup after all references to
             * external components are initialized to start trasport manager.
             **/
            virtual void run(void);

            /**
             * @brief Get list of available devices.
             *
             * @param DeviceList Reference to a variable that will
             *                   receive device list.
             **/
            virtual void getDeviceList(std::vector<SDeviceInfo> & DeviceList) const;

            /**
             * @brief Add listener.
             *
             * @param Listener Pointer to listener.
             **/
            virtual void addListener(ITransportManagerListener * Listener);

            /**
             * @brief Remove listener.
             *
             * @param Listener Pointer to listener.
             **/
            virtual void removeListener(ITransportManagerListener * Listener);

            /**
             * @brief Send frame.
             *
             * @param ConnectionHandle Connection handle.
             * @param Data Frame payload data.
             *
             * @return Frame sequence number. May be used to identify
             *         this frame when send result callback is received.
             **/
            virtual int sendFrame(tConnectionHandle ConnectionHandle, const Blob & Data);

            /**
             * @brief Generate new device handle.
             *
             * Internal method used for generation of unique device handle
             * for device adapters.
             *
             * @return New device handle.
             **/
            tDeviceHandle generateNewDeviceHandle(void);

            /**
             * @brief Generate new connection handle.
             *
             * Internal method used for generation of unique connection handle
             * for device adapters.
             *
             * @return New connection handle.
             **/
            tConnectionHandle generateNewConnectionHandle(void);

        private:
            /**
             * @brief Logger.
             **/
            const log4cplus::Logger mLogger;
        };
    }
}

#endif
